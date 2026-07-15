import { Service } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * Wraps the native `EventSource` API in an RxJS `Observable` so server-sent-event
 * streams can be composed with the rest of the app's reactive/signal-based state
 * (see the `rxResource` usages in `App` and `Home`).
 *
 * `@Service()` is the Angular 22 shorthand for `@Injectable({ providedIn: 'root' })`.
 */
@Service()
export class Sse {
  getServerSentEvent(url: string): Observable<MessageEvent> {
    return new Observable<MessageEvent>((subscriber) => {
      const eventSource = new EventSource(url);

      eventSource.onmessage = (event) => subscriber.next(event);
      eventSource.onerror = (error) => subscriber.error(error);

      return () => eventSource.close();
    });
  }
}
