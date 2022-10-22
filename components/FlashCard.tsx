import { Card, Grid, Text } from '@nextui-org/react'
import React, { FC } from 'react'
import { IFlashCard } from '../interfaces'

interface Props {
  flashCard: IFlashCard
}

export const FlashCard: FC<Props> = ({ flashCard }) => {
  return (
    <Grid xs={6} sm={3}>
      <Card>
        <Card.Body>
          <Text>{flashCard.front}</Text>
        </Card.Body>
      </Card>
    </Grid>
  )
}
