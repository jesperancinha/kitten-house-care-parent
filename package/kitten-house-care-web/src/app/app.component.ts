import {Component, OnInit} from '@angular/core';
import {SseService} from "./sse.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent  implements OnInit {
  title = 'kitten-house-care-web';

  constructor(private sseService: SseService) {}

  ngOnInit(): void {
    this.sseService
      .getServerSentEvent("http://localhost:8082/khc/available")
      .subscribe(data => console.log(data));
  }

}
