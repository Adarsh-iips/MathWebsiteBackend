interface Props {

  keyword: string;

  setKeyword:
    (value: string) => void;

  onSearch:
    () => void;

}

export default function SearchBar({
  keyword,
  setKeyword,
  onSearch
}: Props) {

  return (

    <div
      className="
      flex
      gap-2
      mb-6
      "
    >

      <input
        value={keyword}
        onChange={(e) =>
          setKeyword(
            e.target.value
          )
        }
        placeholder="Search questions..."
        className="
        border
        p-2
        flex-1
        rounded
        "
      />

      <button
        onClick={onSearch}
        className="
        bg-red-600
        text-white
        px-4
        rounded
        "
      >
        Search
      </button>

    </div>

  );
}