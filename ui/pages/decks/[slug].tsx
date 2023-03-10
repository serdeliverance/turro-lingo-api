import { FC } from 'react'
import { GetServerSideProps } from 'next'
import DeckService from '../../services/deck.service'

interface Props {}

const DeckPage: FC<Props> = () => {
  return <h1>DeckPage</h1>
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
