import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { rxResource } from '@angular/core/rxjs-interop';
import { RouterOutlet } from '@angular/router';

import { Sse } from './sse';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.sass',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterOutlet]
})
export class App {
  private readonly sse = inject(Sse);

  protected readonly title = signal('kitten-house-care-web');

  // Replaces the former `getServerSentEvent(...).subscribe(...)` side effect: the SSE stream is
  // now surfaced as reactive, signal-based resource state instead of a manually-managed
  // subscription, so the template can react to it directly.
  protected readonly availability = rxResource({
    stream: () => this.sse.getServerSentEvent('http://localhost:8082/khc/available')
  });
}
