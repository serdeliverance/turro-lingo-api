import { Box, Grid } from '@mui/material'
import { FC } from 'react'
import { Flashcard } from './Flashcard'
import { IFlashCard } from '../../interfaces'

interface Props {
  flashcards: IFlashCard[]
}

export const FlashcardList: FC<Props> = ({ flashcards }) => {
  return (
    <Box flexGrow={1} marginLeft={5} marginRight={5}>
      <Grid container spacing={2}>
        {flashcards.map((fc) => (
          <Flashcard key={fc.id} flashCard={fc} />
        ))}
      </Grid>
    </Box>
  )
}
