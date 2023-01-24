import React from 'react'
import { Button, Navbar as NNavbar, Text } from '@nextui-org/react'
import { MfcLogo } from '.'

export const Navbar = () => {
  return (
    <NNavbar>
      <NNavbar.Brand>
        <MfcLogo />
        <Text b color="inherit" hideIn="xs">
          M-FC
        </Text>
      </NNavbar.Brand>
      <NNavbar.Content>
        <NNavbar.Item>
          <Button>Login</Button>
        </NNavbar.Item>
        <NNavbar.Item>
          <Button>Sign Up</Button>
        </NNavbar.Item>
      </NNavbar.Content>
    </NNavbar>
  )
}
