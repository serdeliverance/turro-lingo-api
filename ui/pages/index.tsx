import { Box, Grid } from '@mui/material'
import type { NextPage } from 'next'
import { Layout } from '../components/ui'
import { Menu } from '../components/menu'
import { useMenuItems } from '../hooks'
import {GetServerSideProps} from "next";
import MenuService from "../services/menu.service";

const HomePage: NextPage = () => {
  const { items, loading } = useMenuItems()

  if (loading) return <h1>Loading...</h1>

  return (
    <>
      <Layout title={'m-flashcards'}>
        {/* TODO add spinner when loading == true*/}
        <Menu items={items} />
      </Layout>
    </>
  )
}

export const getServerSideProps: GetServerSideProps = async () => {
    try {
        const items = await MenuService.getMenuItems()

        if (!items) {
            throw new Error('error retrieving menu items')
        }

        return {
            props: { items },
        }
    } catch (error) {
        console.log(error)
        return {
            redirect: {
                destination: '/',
                permanent: false,
            },
        }
    }
}

export default HomePage
