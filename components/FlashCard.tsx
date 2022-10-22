import { Card, Text } from '@nextui-org/react'
import React, { FC } from 'react'
import { IFlashCard } from '../interfaces'

interface Props {
  flashCard: IFlashCard
}

export const FlashCard: FC<Props> = ({ flashCard }) => {
  return (
    <Card>
      <Card.Body>
        <Text>{flashCard.front}</Text>
      </Card.Body>
    </Card>
  )
}
