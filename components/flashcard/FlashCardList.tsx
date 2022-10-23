import { Grid } from '@nextui-org/react'
import { FC } from 'react'
import { IFlashCard } from '../../interfaces'
import { FlashCard } from './FlashCard'

interface Props {
  flashCards: IFlashCard[]
}

export const FlashCardList: FC<Props> = ({ flashCards }) => {
  return (
    <Grid.Container gap={2}>
      {flashCards.map((fc) => (
        <FlashCard key={fc.id} flashCard={fc} />
      ))}
    </Grid.Container>
  )
}
