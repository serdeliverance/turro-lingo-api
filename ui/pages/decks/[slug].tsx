import { FC } from 'react'
import { GetServerSideProps } from 'next'
import DeckService from '../../services/deck.service'
import { IDeck } from '../../interfaces'
import { Deck } from '../../components/flashcard'

interface Props {
  deck: IDeck
}

const DeckPage: FC<Props> = ({ deck }) => {
  return <Deck deck={deck} />
}

export const getServerSideProps: GetServerSideProps = async ({ params }) => {
  const { slug = '' } = params as { slug: string }

  try {
    const deck = await DeckService.getDeckBySlug(slug)

    if (!deck) {
      throw new Error('deck not found')
    }

    return {
      props: { deck },
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

export default DeckPage
