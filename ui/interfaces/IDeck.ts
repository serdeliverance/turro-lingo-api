import { IFlashCard } from './IFlashCard'

export interface IDeck {
  name: string
  description: string
  type: string
  language: string // refactor to be typed (maybe union type or similar)
  flashcards: IFlashCard[]
  tags: string[]
}
