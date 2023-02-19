import { AppBar, Toolbar, Typography } from '@mui/material'
import React from 'react'
import { MfcLogo } from '.'

export const Navbar = () => {
  return (
    <AppBar position="static">
      <Toolbar>
        <MfcLogo />
        <Typography>MFC</Typography>
      </Toolbar>
    </AppBar>
  )
}
