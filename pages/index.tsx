import type { NextPage } from 'next'
import { FlashcardList } from '../components/flashcard'
import { Layout } from '../components/ui'
import { useFlashcardSet } from '../hooks'
import { IFlashCard } from '../interfaces'

const HomePage: NextPage = () => {
  const { flashcardSet, isLoading } = useFlashcardSet()

  const { flashcards } = flashcardSet

  return (
    { flashcards && (<Layout title={'m-flashcards'}>
    <FlashcardList flashcards={flashcards} />
  </Layout>)}
    
  )
}

export default HomePage
