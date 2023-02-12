import { Box, Grid } from '@mui/material'
import type { NextPage } from 'next'
import { Layout } from '../components/ui'
import { useFlashcardSet } from '../hooks'
import { FlashcardSet } from '../components/flashcard'

const HomePage: NextPage = () => {
  const { flashcardSet, loading } = useFlashcardSet()

  return (
    <>
      <Layout title={'m-flashcards'}>
        <Grid container>
          {loading && <div>loading...</div>}
          {flashcardSet && <FlashcardSet flashcardSet={flashcardSet} />}
        </Grid>
      </Layout>
    </>
  )
}

export default HomePage
