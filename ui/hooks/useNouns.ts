import {INoun} from "../interfaces";

interface UseNounsResponse {
    nouns: INoun[],
    loading: boolean
}

export const useNouns = (): UseNounsResponse => {
    return {
        nouns: [],
        loading: false
    }
}