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
      <h1>What do you want to learn?</h1>
      <Box>
        <Grid container>
          {items.map((item) => (
            <MenuItem item={item} />
          ))}
        </Grid>
      </Box>
    </>
  )
}
