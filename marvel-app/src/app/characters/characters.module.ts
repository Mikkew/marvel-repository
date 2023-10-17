import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@ngbracket/ngx-layout';
import { FormsModule } from '@angular/forms';

import { MaterialModule } from '../material/material.module';
import { TarjetaComponentComponent } from './tarjeta-component/tarjeta-component.component';
import { ImagenPipe } from '../pipes/image.pipe';



@NgModule({
  declarations: [
    TarjetaComponentComponent,
    ImagenPipe
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,
    FormsModule,
    MaterialModule,
  ]
})
export class CharactersModule { }
