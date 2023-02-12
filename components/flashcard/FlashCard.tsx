import { Grid, Paper } from '@mui/material'
import React, { FC, useState } from 'react'
import { IFlashCard } from '../../interfaces'

interface Props {
  flashCard: IFlashCard
}

export const Flashcard: FC<Props> = ({ flashCard }) => {
  const [isFlipped, setIsFlipped] = useState(false)

  const handleClick = () => {
    setIsFlipped(true)
    setTimeout(() => setIsFlipped(false), 10000)
  }

  return (
    <Grid item xs={6} sm={4}>
      {/* TODO add this color to theme or extract to constant */}
      <Paper
        onClick={handleClick}
        elevation={0}
        sx={{
          bgcolor: !isFlipped ? '#0072F5' : '#17C964',
          height: 60,
          textAlign: 'center',
        }}
      >
        {!isFlipped ? flashCard.front : flashCard.back}
      </Paper>
    </Grid>
  )
}
