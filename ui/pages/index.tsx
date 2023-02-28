import { Box, Grid } from '@mui/material'
import type { NextPage } from 'next'
import { Layout } from '../components/ui'
import { Menu } from '../components/menu'
import { useMenuItems } from '../hooks'

const HomePage: NextPage = () => {
  const { items } = useMenuItems()

  return (
    <>
      <Layout title={'m-flashcards'}>
        {/* TODO add spinner when loading == true*/}
        <Menu items={items} />
      </Layout>
    </>
  )
}

export default HomePage
