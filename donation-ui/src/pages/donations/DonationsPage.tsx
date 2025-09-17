import React, { useEffect, useState } from "react";
import AppBackground from "../../components/AppBackground";
import Navigation from "../../components/Navigation";
import Cookies from "js-cookie";
import "./DonationsPage.css";
import { dummyDonors, Donor } from "./dummyDonors";

const mask = (value: string) => value ? value.replace(/./g, "x") : "";


const ITEMS_PER_PAGE = 15;

const DonationsPage: React.FC = () => {
    const [donors, setDonors] = useState<Donor[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [currentPage, setCurrentPage] = useState(1);
    const [isLoggedIn, setIsLoggedIn] = useState(false);


    useEffect(() => {
        setTimeout(() => {
            setDonors(dummyDonors);
            setLoading(false);
        }, 500);
        // Check login status from cookies
        // const token = Cookies.get("token");
        // setIsLoggedIn(!!token);
        setIsLoggedIn(true);
    }, []);

    const totalPages = Math.ceil(donors.length / ITEMS_PER_PAGE);
    const paginatedDonors = donors.slice(
        (currentPage - 1) * ITEMS_PER_PAGE,
        currentPage * ITEMS_PER_PAGE
    );

    const handlePageChange = (page: number) => {
        if (page >= 1 && page <= totalPages) {
            setCurrentPage(page);
        }
    };


    return (
        <>
            <AppBackground />
            <Navigation />
            <div className="donations-outer">
                <div className="donations-content">
                    <h1 className="donations-title">Donations & Donors</h1>
                    {loading ? (
                        <div className="donations-loading">Loading...</div>
                    ) : error ? (
                        <div className="donations-error">{error}</div>
                    ) : (
                        <>
                            <div className="donations-table-wrapper">
                                <table className="donors-table">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Mobile</th>
                                            <th>Blood Type</th>
                                            <th>Organ Donor</th>
                                            <th>Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {paginatedDonors.map(donor => (
                                            <tr key={donor.id}>
                                                <td>{isLoggedIn ? donor.name : mask(donor.name)}</td>
                                                <td>{isLoggedIn ? donor.email : mask(donor.email)}</td>
                                                <td>{isLoggedIn ? donor.mobile : mask(donor.mobile)}</td>
                                                <td>{isLoggedIn ? (donor.bloodType || "-") : mask(donor.bloodType || "-")}</td>
                                                <td>{donor.organDonor ? "Yes" : "No"}</td>
                                                <td>{donor.donationDate ? new Date(donor.donationDate).toLocaleDateString() : "-"}</td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </table>
                                <div className="pagination-controls">
                                    <button
                                        className="pagination-btn"
                                        onClick={() => handlePageChange(currentPage - 1)}
                                        disabled={currentPage === 1}
                                    >
                                        &lt; Prev
                                    </button>
                                    {Array.from({ length: totalPages }, (_, i) => (
                                        <button
                                            key={i + 1}
                                            className={`pagination-btn${currentPage === i + 1 ? " active" : ""}`}
                                            onClick={() => handlePageChange(i + 1)}
                                        >
                                            {i + 1}
                                        </button>
                                    ))}
                                    <button
                                        className="pagination-btn"
                                        onClick={() => handlePageChange(currentPage + 1)}
                                        disabled={currentPage === totalPages}
                                    >
                                        Next &gt;
                                    </button>
                                </div>
                            </div>
                            {!isLoggedIn && (
                                <div className="donations-login-info" style={{ marginTop: '1.5rem' }}>
                                    Please <a href="/login" style={{ color: '#e53935', textDecoration: 'underline' }}>log in</a> to view donor details.
                                </div>
                            )}
                        </>
                    )}
                </div>
            </div>
        </>
    );
};

export default DonationsPage;
