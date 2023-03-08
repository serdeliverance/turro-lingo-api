import React, { FC } from 'react'
import { IDeck } from '../../interfaces'
import { FlashcardList } from './FlashcardList'

interface Props {
  deck: IDeck
}

export const Deck: FC<Props> = ({ deck }) => {
  const { name, flashcards } = deck

  return (
    <div>
      <h1>{name}</h1>
      <FlashcardList flashcards={flashcards} />
    </div>
  )
}
