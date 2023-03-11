import axios from 'axios'
import { IDeck } from '../interfaces'

const getDeckBySlug = async (slug: string): Promise<IDeck | null> => {
  // TODO parameterize server host
  const response = await axios.get<IDeck | null>(
    `http://localhost:8080/api/decks/slug/${slug}`,
  )
  return response.data
}

// TODO define deck service as interface so I can have mock implementations for test
const DeckService = {
  getDeckBySlug,
}

export default DeckService
