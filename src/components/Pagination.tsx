interface Props {

  currentPage: number;

  totalPages: number;

  onPageChange:
    (page: number) => void;

}

export default function Pagination({
  currentPage,
  totalPages,
  onPageChange
}: Props) {

  const pages =
    Array.from(
      {
        length: totalPages
      },
      (_, i) => i
    );

  return (

    <div
      className="
      flex
      gap-2
      justify-center
      mt-8
      "
    >

      {pages.map(page => (

        <button
          key={page}
          onClick={() =>
            onPageChange(page)
          }
          className={`
            px-4
            py-2
            rounded

            ${
              page === currentPage

                ? "bg-red-600 text-white"

                : "bg-gray-200"
            }
          `}
        >
          {page + 1}
        </button>

      ))}

    </div>

  );
}