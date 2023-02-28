import { renderHook } from '@testing-library/react'

import { useMenuItems } from './useMenuItems'

// FIXME issues with jest
describe('useMenuItems should', () => {
  it('return menu items', () => {
    const { result } = renderHook(() => useMenuItems())
    const { items } = result.current
    // TODO add an array of values instead of empty array
    expect(items).to.equal([])
  })

  it('return empty if api call fails', () => {
    const { result } = renderHook(() => useMenuItems())
    const { items } = result.current
    expect(items).to.equal([])
  })

  it('while retrieving elements loading should be true', () => {
    // TODO implement
  })
})
