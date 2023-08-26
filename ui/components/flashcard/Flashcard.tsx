import { Grid, Paper, Typography, useTheme } from '@mui/material'
import React, { FC, useState } from 'react'
import { IFlashCard } from '../../interfaces'

interface Props {
  flashCard: IFlashCard
  frontColor?: string
  backColor?: string
}

export const Flashcard: FC<Props> = ({ flashCard, frontColor, backColor }) => {
  const theme = useTheme()
  const [isFlipped, setIsFlipped] = useState(false)

  const cardFrontColor = frontColor ?? theme.palette.primary.main
  const cardBackColor = backColor ?? theme.palette.success.main

  return (
    <Grid item xs={6} sm={4}>
      <Paper
        onClick={() => {
          setIsFlipped(true)
          setTimeout(() => setIsFlipped(false), 10000)
        }}
        elevation={0}
        sx={{
          bgcolor: !isFlipped ? cardFrontColor : cardBackColor,
          height: 60,
          borderRadius: '4px',
          color: theme.palette.primary.contrastText,
          textAlign: 'center',
        }}
      >
        <Typography variant="body1">
          {!isFlipped ? flashCard.front : flashCard.back}
        </Typography>
      </Paper>
    </Grid>
  )
}
