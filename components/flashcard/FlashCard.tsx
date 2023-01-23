import { Card, Grid, Text, useTheme } from '@nextui-org/react'
import React, { FC, useState } from 'react'
import { IFlashCard } from '../../interfaces'

interface Props {
  flashCard: IFlashCard
}

export const FlashCard: FC<Props> = ({ flashCard }) => {
  const [isFlipped, setIsFlipped] = useState(false)

  const handleClick = () => {
    setIsFlipped(true)
    setTimeout(() => setIsFlipped(false), 6000)
  }

  return (
    <Grid xs={6} sm={4}>
      {/* TODO add this color to theme or extract to constant */}
      <Card
        css={{
          backgroundColor: !isFlipped ? '#0072F5' : '#17C964',
        }}
      >
        <Card.Body onClick={handleClick}>
          <Text css={{ color: 'white' }}>
            {!isFlipped ? flashCard.front : flashCard.back}
          </Text>
        </Card.Body>
      </Card>
    </Grid>
  )
}
