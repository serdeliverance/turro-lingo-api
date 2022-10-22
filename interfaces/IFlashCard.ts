export interface IFlashCard {
  id: number
  front: string
  back: string
  // TODO add frontLang
  // TODO add backLang
  // TODO tag as string for now, maybe in the future could be another type
  tags: string[]
  createdAt?: string
  updatedAt?: string
}

// TODO Tag interface idea for possible future refactor
// interface Tag {
//     id?: number
//     name: string
// }
