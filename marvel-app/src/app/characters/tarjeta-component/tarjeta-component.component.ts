import { Character } from './../../../interface/Character.interface';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-tarjeta-component',
  templateUrl: './tarjeta-component.component.html',
  styleUrls: ['./tarjeta-component.component.css']
})
export class TarjetaComponentComponent implements OnInit {

  @Input()
  character!: Character;

  constructor() { }

  ngOnInit(): void {
  }
}
