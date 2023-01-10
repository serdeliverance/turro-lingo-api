import { Grid } from '@nextui-org/react'
import { FC } from 'react'
import { IFlashCard } from '../../interfaces'
import { FlashCard } from './FlashCard'

interface Props {
  flashcards: IFlashCard[]
}

export const FlashcardList: FC<Props> = ({ flashcards }) => {
  return (
    <Grid.Container gap={2}>
      {flashcards.map((fc) => (
        <FlashCard key={fc.id} flashCard={fc} />
      ))}
    </Grid.Container>
  )
}
