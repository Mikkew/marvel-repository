import { Character } from './../../interface/Character.interface';
import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'imagen'
})
export class ImagenPipe implements PipeTransform {

  transform(character: Character): string {
    return character.urlImage
  }
}
