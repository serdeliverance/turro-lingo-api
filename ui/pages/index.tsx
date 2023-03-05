import { Box, Grid } from '@mui/material'
import type { NextPage } from 'next'
import { Layout } from '../components/ui'
import { Menu } from '../components/menu'
import { useMenuItems } from '../hooks'

const HomePage: NextPage = () => {
  const { items, loading, error } = useMenuItems()

    if (loading) return (<h1>Loading...</h1>)

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
