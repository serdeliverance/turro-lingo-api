import type { NextPage } from 'next'
import { FlashcardList } from '../components/flashcard'
import { Layout } from '../components/ui'
import { useFlashcardSet } from '../hooks'

const HomePage: NextPage = () => {
  const { flashcardSet, loading } = useFlashcardSet()

  // TODO fix this nullable values handling (should not be optional)
  const flashcards = flashcardSet?.flashcards || []
  const subject = flashcardSet?.subject

  return (
    <>
      <Layout title={'m-flashcards'}>
        {subject && <h1>{subject}</h1>}
        {loading && <div>loading...</div>}
        <FlashcardList flashcards={flashcards} />
      </Layout>
    </>
  )
}

export default HomePage
