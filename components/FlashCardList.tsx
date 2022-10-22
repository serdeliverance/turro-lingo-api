import { FC } from 'react'
import { IFlashCard } from '../interfaces'
import { FlashCard } from './FlashCard'


interface Props {
  flashCards: IFlashCard[]
}

export const FlashCardList: FC<Props> = ({ flashCards }) => {
  return (
    <>
        {
            flashCards.map(fc => (<FlashCard key={fc.id} flashCard={fc} />))
        }
    </>
  )
}
