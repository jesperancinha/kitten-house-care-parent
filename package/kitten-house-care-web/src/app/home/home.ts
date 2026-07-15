import { ChangeDetectionStrategy, Component, inject } from '@angular/core';
import { rxResource } from '@angular/core/rxjs-interop';

import { Sse } from '../sse';

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  styleUrl: './home.sass',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class Home {
  private readonly sse = inject(Sse);

  // Same rxResource-based replacement of the former subscribe() side effect as in `App`.
  protected readonly availability = rxResource({
    stream: () => this.sse.getServerSentEvent('http://localhost:8082/khc/available')
  });
}
