import { IFlashCard } from './IFlashCard'

export interface IFlashCardSet {
  subject: string
  language: string // refactor to be typed (maybe union type or similar)
  flashcards: IFlashCard[]
}
