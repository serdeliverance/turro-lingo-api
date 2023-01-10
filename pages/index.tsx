import type { NextPage } from 'next'
import { FlashcardList } from '../components/flashcard'
import { Layout } from '../components/ui'
import { useFlashcardSet } from '../hooks'
import { IFlashCard } from '../interfaces'

const flashcards: IFlashCard[] = [
  {
    id: 1,
    front: 'Ich möchte ein Bier',
    back: 'I want a beer',
    tags: ['social'],
  },
  { id: 2, front: 'Pass du auf', back: 'take care', tags: ['social'] },
  {
    id: 3,
    front: 'Ich möchte ein Bier',
    back: 'I want a beer',
    tags: ['social'],
  },
  { id: 4, front: 'Pass du auf', back: 'take care', tags: ['social'] },
  {
    id: 5,
    front: 'Ich möchte ein Bier',
    back: 'I want a beer',
    tags: ['social'],
  },
  { id: 6, front: 'Pass du auf', back: 'take care', tags: ['social'] },
  {
    id: 7,
    front: 'Ich möchte ein Bier',
    back: 'I want a beer',
    tags: ['social'],
  },
  { id: 8, front: 'Pass du auf', back: 'take care', tags: ['social'] },
  {
    id: 9,
    front: 'Ich möchte ein Bier',
    back: 'I want a beer',
    tags: ['social'],
  },
  { id: 10, front: 'Pass du auf', back: 'take care', tags: ['social'] },
]

const HomePage: NextPage = () => {
  const { flashcardSet, isLoading } = useFlashcardSet()

  return (
    <Layout title={'m-flashcards'}>
      <FlashcardList flashcards={flashcards} />
    </Layout>
  )
}

export default HomePage
