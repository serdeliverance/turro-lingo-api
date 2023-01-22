import type { NextPage } from 'next'
import { FlashcardList } from '../components/flashcard'
import { Layout } from '../components/ui'
import { useFlashcardSet } from '../hooks'

const HomePage: NextPage = () => {
  const { flashcardSet, loading } = useFlashcardSet()

  const flashcards = flashcardSet?.flashcards || []

  return (
    <>
      {loading && <div>loading...</div>}
      <Layout title={'m-flashcards'}>
        <FlashcardList flashcards={flashcards} />
      </Layout>
    </>
  )
}

export default HomePage
