import { Grid } from '@mui/material'
import { FC } from 'react'
import { Flashcard } from '.'
import { IFlashCard } from '../../interfaces'

interface Props {
  flashcards: IFlashCard[]
}

export const FlashcardList: FC<Props> = ({ flashcards }) => {
  return (
    <Grid container gap={2}>
      {flashcards.map((fc) => (
        <Flashcard key={fc.id} flashCard={fc} />
      ))}
    </Grid>
  )
}
