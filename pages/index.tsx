import type { NextPage } from 'next'
import { FlashCardList } from '../components'
import { IFlashCard } from '../interfaces'
import styles from '../styles/HomePage.module.css'

const flashCards: IFlashCard[] = [
  { id: 1, front: 'Ich möchte ein Bier', back: 'I want a beer', tags: ['social']},
  { id: 2, front: 'Pass du auf', back: 'take care', tags: ['social'] }
]

const HomePage: NextPage = () => {
  return <FlashCardList flashCards={flashCards} />
}

export default HomePage
