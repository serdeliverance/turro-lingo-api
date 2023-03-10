import React, { FC } from 'react'
import { FlashcardList } from './FlashcardList'
import { IDeck } from '../../interfaces'

interface Props {
  deck: IDeck
}

export const Deck: FC<Props> = ({ deck }) => {
  const { name, description, flashcards } = deck
  return (
    <div>
      <h1>{name}</h1>
      {description && <h2>{description}</h2>}
      <FlashcardList flashcards={flashcards} />
    </div>
  )
}
