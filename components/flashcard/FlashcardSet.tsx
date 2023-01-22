import React, { FC } from 'react'
import { IFlashCardSet } from '../../interfaces'
import { FlashcardList } from './FlashcardList'

interface Props {
  flashcardSet: IFlashCardSet
}

export const FlashcardSet: FC<Props> = ({ flashcardSet }) => {
  const { subject, flashcards } = flashcardSet

  return (
    <div>
      <h1>{subject}</h1>
      <FlashcardList flashcards={flashcards} />
    </div>
  )
}
