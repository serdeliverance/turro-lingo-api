import { IMenuItem } from '../../interfaces'
import React, { FC } from 'react'
import { Grid, Paper, Typography, useTheme } from '@mui/material'
import { useRouter } from 'next/router'

interface Props {
  item: IMenuItem
}

export const MenuItem: FC<Props> = ({ item }) => {
  const theme = useTheme()

  const router = useRouter()

  return (
    <Grid item xs={12} sm={6}>
      <Paper
        elevation={0}
        sx={{
          bgcolor: theme.palette.primary.main,
          height: 60,
          borderRadius: '4px',
          color: theme.palette.primary.contrastText,
          textAlign: 'center',
        }}
        onClick={() => router.push(`/decks/${item.slug}`)}
      >
        <Typography variant="h4">{item.name}</Typography>
      </Paper>
    </Grid>
  )
}
