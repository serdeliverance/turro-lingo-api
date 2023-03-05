import { FC } from 'react'
import { GetServerSideProps } from 'next'

interface Props {}

const DeckPage: FC<Props> = () => {
  return <h1>DeckPage</h1>
}

export const getServerSideProps: GetServerSideProps = async ({ params }) => {
  const { slug = '' } = params as { slug: string }
  // TODO implement
  return {
    props: {},
  }
}

export default DeckPage
