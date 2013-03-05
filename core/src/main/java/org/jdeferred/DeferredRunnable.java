package org.jdeferred;

import org.jdeferred.impl.DeferredObject;

/**
 * Use this as superclass in case you need to be able to be able to notify progress.
 * If you don't need to notify progress, you can simply use {@link Runnable}
 * 
 * @see #notify(Object)
 * @author Ray Tsang
 *
 * @param <P> Type used for {@link Deferred#notify(Object)}
 */
public abstract class DeferredRunnable<P> implements Runnable {
	private final Deferred<Void, Throwable, P> deferred = new DeferredObject<Void, Throwable, P>();
	
	/**
	 * @see Deferred#notify(Object)
	 * @param progress
	 */
	protected void notify(P progress) {
		deferred.notify(progress);
	}
	
	protected Deferred<Void, Throwable, P> getDeferred() {
		return deferred;
	}
}
