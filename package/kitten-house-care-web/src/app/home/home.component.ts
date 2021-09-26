import {Component, OnInit} from "@angular/core";
import {SseService} from "../sse.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  constructor(private sseService: SseService) {}

  ngOnInit(): void {
    this.sseService
      .getServerSentEvent("http://localhost:8082/khc/available")
      .subscribe(data => console.log(data));
  }

}
