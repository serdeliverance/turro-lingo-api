import { Grid, Paper, Typography, useTheme } from '@mui/material'
import React, { FC, useState } from 'react'
import { IFlashCard } from '../../interfaces'

interface Props {
  flashCard: IFlashCard
}

export const Flashcard: FC<Props> = ({ flashCard }) => {
  const theme = useTheme()
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
          bgcolor: !isFlipped
            ? theme.palette.primary.main
            : theme.palette.success.main,
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
