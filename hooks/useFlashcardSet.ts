import useSWR, { SWRConfiguration } from 'swr'
import { IFlashCardSet } from '../interfaces'

export const useFlashcardSet = (config: SWRConfiguration = {}) => {
  const { data, error } = useSWR<IFlashCardSet>('/api/flashcards')

  return {
    flashcardSet: data || [],
    isLoading: !error && !data,
    isError: error,
  }
}
