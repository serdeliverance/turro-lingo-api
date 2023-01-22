export interface IFlashCard {
  id: number
  front: string
  back: string
  tags: string[]
  createdAt?: string
  updatedAt?: string
}
