export interface Character {
  id?:          number;
  name:         string;
  urlImage:     string;
  urlDetails:   string;
  comics:       Comics;
}

export interface Comics {
  total:        number;
  comics:       string[];
}

export const character: Character = {
  name: "",
  urlImage: "",
  urlDetails: "",
  comics: {} as Comics
}

export const comics: Comics = {
  total: 0,
  comics: []
}
