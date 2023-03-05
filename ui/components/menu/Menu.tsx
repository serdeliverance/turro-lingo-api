import { FC } from 'react'
import { IMenuItem } from '../../interfaces'
import { Box, Grid } from '@mui/material'
import { MenuItem } from './MenuItem'

interface Props {
  items: IMenuItem[]
}

export const Menu: FC<Props> = ({ items }) => {
  return (
    <>
      <Box sx={{ padding: 2 }}>
        <h1>What do you want to learn?</h1>
        <Box sx={{ paddingX: 5, paddingY: 2 }}>
          <Grid container spacing={2}>
            {items.map((item) => (
              <MenuItem key={item.id} item={item} />
            ))}
          </Grid>
        </Box>
      </Box>
    </>
  )
}
