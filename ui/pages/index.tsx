import { Box, Grid } from '@mui/material'
import type { NextPage } from 'next'
import { Layout } from '../components/ui'
import { Menu } from '../components/menu'
import { useMenuItems } from '../hooks'

const items = [
    {
        id: 1,
        name: 'german 101'
    },
    {
        id: 2,
        name: 'vocabulary'
    },
    {
        id: 3,
        name: 'sayings'
    },
    {
        id: 4,
        name: 'xxx'
    },
    {
        id: 5,
        name: 'xxx'
    },
    {
        id: 6,
        name: 'something'
    }
]

const HomePage: NextPage = () => {
  // const { items } = useMenuItems()

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
